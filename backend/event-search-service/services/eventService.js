const EventDescription =
require("../models/eventDescription");

const EventEmbedding =
require("../models/eventEmbedding");


// simple vector generator
// (later we can replace with real embedding logic)
function createVector(text){

    let vector = [];

    for(let i=0;i<text.length;i++){

        vector.push(
            text.charCodeAt(i)
        );

    }

    return vector.slice(0,10);

}



const createEvent = async(data)=>{


    const text =
    data.title + " " +
    data.description;


    const vector =
    createVector(text);



    const event =
    await EventDescription.create({

        title:data.title,

        description:data.description,

        venue:data.venue,

        eventDate:data.eventDate,

        vector:vector

    });



    await EventEmbedding.create({

        eventId:event._id,

        vector:vector

    });



    return event;

};



module.exports = {

    createEvent

};