const mongoose = require("mongoose");


const eventDescriptionSchema = new mongoose.Schema({

    title:{
        type:String,
        required:true
    },

    description:{
        type:String
    },

    venue:{
        type:String
    },

    eventDate:{
        type:String
    },

    vector:{
        type:Array
    },

    createdAt:{
        type:Date,
        default:Date.now
    }

});


module.exports =
mongoose.model(
    "event_descriptions",
    eventDescriptionSchema
);