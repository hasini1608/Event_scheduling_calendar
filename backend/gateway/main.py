from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
import requests

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://localhost:5173"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

SPRING_URL = "http://localhost:8001"


@app.get("/")
def home():
    return {"message":"Gateway Running"}


# ---------------- USERS ----------------

@app.post("/users/signup")
def signup(data:dict):

    response = requests.post(
        f"{SPRING_URL}/users/signup",
        json=data
    )

    return response.json()


@app.post("/users/login")
def login(data:dict):

    response = requests.post(
        f"{SPRING_URL}/users/login",
        json=data
    )

    return response.json()


@app.get("/users/all")
def all_users():

    response = requests.get(
        f"{SPRING_URL}/users/all"
    )

    return response.json()


# ---------------- EVENTS ----------------

@app.post("/events/create")
def create_event(data:dict):

    response = requests.post(
        f"{SPRING_URL}/events/create",
        json=data
    )

    return response.json()


@app.get("/events/all")
def all_events():

    response = requests.get(
        f"{SPRING_URL}/events/all"
    )

    return response.json()


@app.delete("/events/delete/{id}")
def delete_event(id:int):

    response = requests.delete(
        f"http://localhost:8001/events/delete/{id}"
    )

    return {
        "message": response.text
    }

@app.put("/events/update/{id}")
def update_event(id:int,event:dict):

    response=requests.put(
        f"http://localhost:8001/events/update/{id}",
        json=event
    )

    return response.json()

# ---------------- REGISTRATIONS ----------------

@app.post("/registrations/create")
def create_registration(data: dict):

    response = requests.post(
        f"{SPRING_URL}/registrations/create",
        json=data
    )

    return response.json()


@app.get("/registrations/all")
def all_registrations():

    response = requests.get(
        f"{SPRING_URL}/registrations/all"
    )

    return response.json()


@app.delete("/registrations/delete/{id}")
def delete_registration(id: int):

    response = requests.delete(
        f"{SPRING_URL}/registrations/delete/{id}"
    )

    return {
        "message": response.text
    }