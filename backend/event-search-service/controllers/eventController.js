const eventService =
require("../services/eventService");



const createEvent = async(req,res)=>{


try{


const event =
await eventService.createEvent(
    req.body
);


res.json(event);



}
catch(error){


console.log(error);


res.status(500).json({

message:"Event creation failed"

});


}

};



module.exports={
    createEvent
};