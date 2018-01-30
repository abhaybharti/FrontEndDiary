var url = "http://wickedlysmart.com/ifeelluckytoday";

var request = new XMLHttpRequest();

request.open("GET", url);

//Handler will check if response is received & let us know
request.onload = function() {
	if (request.status == 200) {
		alert(request.responseText);
		displayLuck(request.responseText);
	}
};

request.send(null);

function displayLuck(luck){
	var p = document.getElementById("luck");
	p.innerHTML = "Today you are " + luck;
}