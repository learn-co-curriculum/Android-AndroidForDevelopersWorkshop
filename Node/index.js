var express = require('express'); 
var bodyParser = require('body-parser'); 
var app = express(); 

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
var port = 8080;
app.listen(port); 

console.log('server is running on port: ' + port); 

