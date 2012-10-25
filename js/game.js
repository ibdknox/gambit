(function(window) {

var curId = 0;
var entities = {};
var EtoC = {};
var CtoE = {};

var game = {

    entities: entities,
    EtoC: EtoC,
    CtoE: CtoE,

    nextId: function() {
        return curId++;
    },

    as: function(ent, c) {
        var n = c.name ? c.name : c;
        return EtoC[ent][n];
    },

    has: function(ent, c) {
        return game.as(ent,c) ? true : false;
    },

    addC: function(ent, c) {
        EtoC[ent][c.name] = c;
        if(!CtoE[c.name]) {
            CtoE[c.name] = {};
        }
        CtoE[c.name][ent] = true;
    },

    remC: function(ent, c) {
        var n = c.name ? c.name : c;
        delete EtoC[ent][n];
        delete CtoE[n][ent];
    },

    allE: function(c) {
        var n = c.name ? c.name : c;
        return Object.keys(CtoE[n] || {});
    },

    allC: function(e) {
        return Object.keys(EtoC[e]);
    },

    create: function(moniker) {
        var id = game.nextId();
        entities[id] = moniker;
        EtoC[id] = {};
        return id;
    },

    destroy: function(ent) {
        for(var c in game.allC(ent)) {
            remC(ent, c);
        }
        delete entities[ent];
    }

};

window.Game = game;

})(window);
