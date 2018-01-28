var button = document.getElementById("addButton");
button.onclick = handleButtonClick;

window.onload = init;

function init() {
	loadPlaylist();
}

function handleButtonClick(){
	var textInput = document.getElementById("songTextInput");
	var songName = textInput.value;
	
	if (songName == ""){
		alert("Please enter song");
	} else {
		var li = document.createElement("li"); //create a new li element
		li.innerHTML=songName;
		
		var ul = document.getElementById("playlist"); //get reference to existing UL
		ul.appendChild(li); //adding child element to DOM
		save(songName);
	}
}

function save(item) {
	var playlistArray = getStoreArray("playlist");
	playlistArray.push(item);
	localStorage.setItem("playlist", JSON.stringify(playlistArray));
}

function loadPlaylist() {
	var playlistArray = getSavedSongs();
	var ul = document.getElementById("playlist");
	if (playlistArray != null) {
		for (var i = 0; i < playlistArray.length; i++) {
			var li = document.createElement("li");
			li.innerHTML = playlistArray[i];
			ul.appendChild(li);
		}
	}
}

function getSavedSongs() {
	return getStoreArray("playlist");
}

function getStoreArray(key) {
	var playlistArray = localStorage.getItem(key);
	if (playlistArray == null || playlistArray == "") {
		playlistArray = new Array();
	}
	else {
		playlistArray = JSON.parse(playlistArray);
	}
	return playlistArray;
}