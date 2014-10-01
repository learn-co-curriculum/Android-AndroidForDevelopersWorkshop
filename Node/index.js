var express = require('express'); 
var bodyParser = require('body-parser'); 
var app = express(); 
//Comment
app.use(bodyParser.urlencoded({extended: true})); 
app.use(bodyParser.json()); 

var router = express.Router(); 
router.use(function(req, res, next) {
	next(); 
});

// routes =======================
app.use('/api/v1', router); 
require('./routes')(router); 


// launch ======================
app.set('port', (process.env.PORT || 5000)); 
app.listen(app.get('port'), function(){
  console.log("Node app running on port: "+ app.get('port')); 
}); 
