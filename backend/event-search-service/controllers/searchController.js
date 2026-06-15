const EventDescription =
require("../models/eventDescription");


const searchEvents = async(req,res)=>{

    try{

        const query =
        req.params.query;


        const result =
        await EventDescription.find({
            $or:[
                {
                  title:{
                    $regex:query,
                    $options:"i"
                  }
                },
                {
                  description:{
                    $regex:query,
                    $options:"i"
                  }
                }
            ]
        });


        res.json(result);


    }
    catch(error){

        res.status(500).json({
            message:"Search failed"
        });

    }

};


module.exports={
    searchEvents
};