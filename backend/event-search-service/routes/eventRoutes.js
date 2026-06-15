const express = require("express");
const axios = require("axios");

const router = express.Router();

const Event =
require("../models/eventDescription");


router.post(
"/create",
async(req,res)=>{


try{

const text =
req.body.title + " " +
req.body.description;


const vector =
text
.split("")
.slice(0,10)
.map(c=>c.charCodeAt(0));

// save MongoDB

const mongoEvent =
await Event.create({

title:req.body.title,

description:req.body.description,

venue:req.body.venue,

eventDate:req.body.eventDate,

vector:vector

});

// save Spring Boot PostgreSQL

await axios.post(
"http://localhost:8001/events/create",
{

title:req.body.title,

description:req.body.description,

venue:req.body.venue,

eventDate:req.body.eventDate,

startTime:req.body.startTime,

endTime:req.body.endTime,

capacity:req.body.capacity

}
);



res.json({
message:"Event created in MongoDB and PostgreSQL",
event:mongoEvent
});



}catch(error){

console.log(error.message);

res.status(500).json({
error:"creation failed"
});

}



});


module.exports = router;