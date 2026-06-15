const express=require("express");

const router=express.Router();

const {
searchEvents
}=require("../controllers/searchController");


router.get(
"/search/:query",
searchEvents
);


module.exports=router;