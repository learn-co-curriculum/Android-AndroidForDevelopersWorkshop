module.exports = function(router){
	router.route('/madlibs')
	.post(function(req, res){
		var places = req.body["places"], 
		    people = req.body["people"],
		    verbs = req.body["verbs"],
		    adjectives = req.body["adjectives"]; 

		var story = createStory(places, people, verbs, adjectives);

		var storyJson = {"story" : JSON.stringify(story)}; 
		console.log(storyJson);
 
		res.send(JSON.stringify(story));  
	}); 
}

function createStory(places, people, verbs) {
	var story = "Today we'll be going on a journey to " + randomString(places).capitalize() +
	 ". If you've never been before, it's a magical place full of happy people like " + randomString(people).capitalize() +
		 ". Learning Android can be a challenging experience, but I promise, if " + randomString(people).capitalize() +
		  " can do it, so can you! " + "So " + randomString(verbs) + 
		  " hard and make sure to " + randomString(verbs) + " bravely!";  

	return story; 
}

String.prototype.capitalize = function () {
	return this.charAt(0).toUpperCase() + this.slice(1);
}

function randomString(arr){
	if (typeof arr == 'string' || arr instanceof String) {
		return arr;
	}
	else {
		var randomNum = Math.floor(Math.random() * arr.length)
		var randomString = arr[randomNum]; 
		arr.splice(randomNum, 1); 
		
		return randomString;
	} 
}