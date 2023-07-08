import axios from 'axios';
import {useState} from 'react';

export default function SearchForTrains() {

    let source = '', destination = ''; //useState for source and destination as well
    const [listOfTrains, setListOfTrains] = useState([]);

    function readSource(event) {
        source = event.target.value;
    }
    function readDestination(event) {
        destination = event.target.value;
    }

    function search(event)  {
        event.preventDefault();
        //alert(source + " , " + destination);
        let url = `http://localhost:9090/trains?source=${source}&destination=${destination}`;
        axios.get(url).then((response) => {
            //console.log(response.data);
            setListOfTrains(response.data);
        })
    }

    let t  = [];
    for(let train of listOfTrains) {
        t.push(
            <div>
                Train No: {train.id} <br />
                Name : {train.name} <br />
                Departure Time : {train.departureTime} <br />
                Arrival Time : {train.arrivalTime} <br />
            </div>
        )
    }

    return (
            <div>
                <form onSubmit={search}>
                    Enter source : <input onChange={readSource} /> <br />
                    Enter destination : <input onChange={readDestination} /> <br />
                    <button type='submit'>Search</button>
                </form>
                {t}
            </div>
    )
}