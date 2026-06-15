const express = require("express");

const router = express.Router();

const Activity =
require("../models/userActivity");



router.post(
"/activity/create",
async(req,res)=>{


try{


const log =
await Activity.create(
req.body
);


res.json(log);



}catch(error){


res.status(500).json({
message:"log failed"
});


}



});


module.exports=router;