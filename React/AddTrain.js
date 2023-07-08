import axios from 'axios';
import {useState} from 'react';

export default function AddTrain() {

    const [trainData, setTrainData] = useState({name : '', source : '', destination : ''})

    function handleInput(event) {
        setTrainData((prevValues) => {
            return {
                ...prevValues,
                [event.target.name] : event.target.value
            }
        })
    }

    function sendData(event) {
        event.preventDefault();
        console.log(trainData);
        let url = 'http://localhost:9090/add-train';
        axios.post(url, trainData).then((response) => {
            console.log(response.data);
        })
    }


    return (
        <form onSubmit={sendData}>
            Enter name : <input name="name" onChange={handleInput} /> <br />
            Enter source : <input name="source" onChange={handleInput} /> <br />
            Enter destination : <input name="destination" onChange={handleInput} /> <br />
            <button type='submit'>Add</button>
        </form>
    )
}
