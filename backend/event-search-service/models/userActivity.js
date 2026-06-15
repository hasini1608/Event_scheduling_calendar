const mongoose = require("mongoose");


const userActivitySchema =
new mongoose.Schema({

    userId:{
        type:String
    },

    action:{
        type:String
    },

    query:{
        type:String
    },

    eventId:{
        type:String
    },

    createdAt:{
        type:Date,
        default:Date.now
    }

});


module.exports =
mongoose.model(
"user_activity_logs",
userActivitySchema
);