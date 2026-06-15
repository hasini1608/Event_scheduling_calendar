const express = require("express");
const cors = require("cors");
require("dotenv").config();

const connectDB = require("./config/db");

const app = express();


connectDB();


app.use(cors());

app.use(express.json());



app.get("/",(req,res)=>{

    res.send(
      "Event Search Service Running"
    );

});



// routes

const eventRoutes =
require("./routes/eventRoutes");


app.use(
"/event-search",
eventRoutes
);



const searchRoutes =
require("./routes/searchRoutes");


app.use(
"/event-search",
searchRoutes
);



// ADD THIS HERE

const activityRoutes =
require("./routes/activityRoutes");


app.use(
"/event-search",
activityRoutes
);





const PORT =
process.env.PORT || 8002;



app.listen(PORT,()=>{

    console.log(
      `Server running on ${PORT}`
    );

});