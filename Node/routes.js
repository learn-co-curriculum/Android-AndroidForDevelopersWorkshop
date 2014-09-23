module.exports = function(router){
	router.route('/madlibs')
	.post(function(req, res){
		var places = req.body["places"], 
		    people = req.body["people"],
		    verbs = req.body["verbs"],
		    adjectives = req.body["adjectives"]; 

		var story = createStory(places, people, verbs, adjectives);

		res.send(story);  
	}); 
}

function createStory(places, people, verbs, adjectives) {
	var story = "Today we'll be going on a journey to " + randomString(places) +
	 ". If you've never been before, " + randomString(people) +
	 ", it's a " + randomString(adjectives) + " place full of " + 
		randomString(adjectives) + " people like " + randomString(people) +
		 ". Learning Android can be a " + randomString(adjectives) +
		 " experience, but I promise, if " + randomString(people) +
		  " can do it, so can you! " + "So " + randomString(verbs) + 
		  " " + randomString(adjectives) + " like " + randomString(people) +
		   " and make sure to " + randomString(verbs) + " " + randomString(adjectives) + "!";  

	return story; 
}

function randomString(arr){
	var randomNum = Math.floor(Math.random() * arr.length)

	var randomString = arr[randomNum]; 
	arr.splice(randomNum, 1); 
	
	return randomString; 
}