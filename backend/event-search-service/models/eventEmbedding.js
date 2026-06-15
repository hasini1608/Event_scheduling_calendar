const mongoose = require("mongoose");


const eventEmbeddingSchema =
new mongoose.Schema({

    eventId:String,

    vector:Array,

    createdAt:{
        type:Date,
        default:Date.now
    }

});


module.exports =
mongoose.model(
"event_embeddings",
eventEmbeddingSchema
);