var exec = require('cordova/exec');

var Beacon=function(){
};


/*
exports.coolMethod = function(arg0, success, error) {
    exec(success, error, "Beacon", "coolMethod", [arg0]);
};
*/

Beacon.prototype.scanBeacon = function(successCallback, errorCallback)
{
	exec(successCallback, errorCallback, "Beacon", "scanBeacon", []);	
}

module.exports = Beacon;
