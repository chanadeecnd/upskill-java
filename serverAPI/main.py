from fastapi import FastAPI

app = FastAPI()

@app.get("/")
def root():
    return {
        "message":"Hello serverAPI",
        "status":"200",
        "name":"chanadee"
    }

@app.get('/sum/{x}&{y}')
def sum(x,y):
    input1 = int(x)
    input2 = int(y)
    result = input1 + input2
    return {
        "message":"this is sum function",
        "result": result
    }