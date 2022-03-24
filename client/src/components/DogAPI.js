import React, { useState, useEffect } from 'react'
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper } from '@mui/material';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import axios from "axios";

const dogUrl = "https://dog.ceo/api/breeds/image/random";

function Dog() {
    const [userData, setUserData] = useState({})

    useEffect(() => {
        getDogFactWithAxios();

    }, []);

    const getDogFactWithAxios = async () => {
        const response = await axios.get(dogUrl);
        setUserData(response.data);
        console.log(response.data);
    }

    return (
        <div className="Dog">
            <header className="Dog-header">
                <h2>Random dog pic!!!</h2>
            </header>

            <div className="pic-container">
                <h5 className="header">Look at this beautiful pupper!</h5>
                {/* <h5 className="header">Offender Is Rehabilitated</h5> */}
                <img src={userData.message}></img>
                <h2>How did the little Scottish dog react when he met the Loch Ness Monster?
                    He was Terrier-fied!</h2>
                {/* <img src="Cesar_Millan_Mar_2018.png" style={{height:'300px'}}></img> */}

            </div>


        </div>

    )


}

export default Dog