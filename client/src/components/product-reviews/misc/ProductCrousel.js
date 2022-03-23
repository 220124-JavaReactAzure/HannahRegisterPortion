import React, { useState } from 'react'
import { Col, Row, Container, Image, Card, Carousel } from "react-bootstrap";

function ProductCrousel(props) {    // const pics = ['cellphone', 'shirt', 'shoes', 'drone', 'scooter', 'pants', 'travel', 'calm', 'javascript']
    const pics = [{
        "src": "images (a).png",
        "fullname": "Guilty",
        "alias": "Guilty AF",
        "dob": "FEB 09, 2022",
        "sex": "M",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "images (b).png",
        "fullname": "Bad Dog",
        "alias": "'Bad' the Dog",
        "dob": "FEB 09, 2022",
        "sex": "M",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "images (c).png",
        "fullname": "Douglas Dog",
        "alias": "'Doug' the Dog",
        "dob": "FEB 09, 2022",
        "sex": "M",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "images (5).png",
        "fullname": "NIKOLAI ONDREJKO",
        "alias": "DINGGLE BERRY BANDIT",
        "dob": "FEB 09, 2022",
        "sex": "M",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "images (3).png",
        "fullname": "Snoop Puppy Pup",
        "alias": "Calvin Cordozar Broadus Jr",
        "dob": "FEB 09, 2022",
        "sex": "M",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "images (4).png",
        "fullname": "Kim Bassethound",
        "alias": "DINGGLE BERRY BANDIT",
        "dob": "FEB 09, 2022",
        "sex": "F",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "images (10).png",
        "fullname": "ICE CUB",
        "alias": "DINGGLE BERRY BANDIT",
        "dob": "FEB 09, 2022",
        "sex": "M",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "images (11).png",
        "fullname": "Don Vito Corleone",
        "alias": "The Godfather",
        "dob": "FEB 09, 2022",
        "sex": "M",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "download (1).png",
        "fullname": "Natasha ONDREJKO",
        "alias": "DINGGLE BERRY BANDIT",
        "dob": "FEB 09, 2022",
        "sex": "F",
        "height": "1' 2\"",
        "weight": "50",
        "eyes": "BRN",
        "hair": "BRN"
    },

    {
        "src": "cat-with-attitude.png",
        "fullname": "Marty McMeow",
        "alias": "Michael J Cat",
        "dob": "FEB 09, 2022",
        "sex": "M",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "attitude-feat.png",
        "fullname": "NIKOLAI Cagged",
        "alias": "DINGGLE BERRY BANDIT",
        "dob": "FEB 09, 2022",
        "sex": "F",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "cat-4694065_960_720.png",
        "fullname": "Ted Tabby",
        "alias": "Ira Tay",
        "dob": "FEB 09, 2022",
        "sex": "M",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "quy3t9tjvia61.png",
        "fullname": "Clint Eastcat",
        "alias": "Sheriff",
        "dob": "FEB 09, 2022",
        "sex": "M",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "shutterstock_129390089_1.png",
        "fullname": "Norman Bats",
        "alias": "Psycho",
        "dob": "FEB 09, 2022",
        "sex": "M",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "grumpy_cat.png",
        "fullname": "Tartar Sauce",
        "alias": "Grumpy Cat",
        "dob": "FEB 09, 2022",
        "sex": "F",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "famous-cats1.png",
        "fullname": "Salvador Doggy",
        "alias": "Salvador Cat",
        "dob": "FEB 09, 2022",
        "sex": "M",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "Cat-Cosplaying-as-Dr-Strange.png",
        "fullname": "Doctor Strange Cat",
        "alias": "Doctor Cat",
        "dob": "FEB 09, 2022",
        "sex": "M",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "images (13).png",
        "fullname": "Captain Jack Sparrow",
        "alias": "Grumpy Cat",
        "dob": "FEB 09, 2022",
        "sex": "M",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "images (12).png",
        "fullname": "Audrey Hepcat",
        "alias": "Grumpy Cat",
        "dob": "FEB 09, 2022",
        "sex": "F",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },

    {
        "src": "images (14).png",
        "fullname": "Obi Wan Catnobi",
        "alias": "Grumpy Cat",
        "dob": "FEB 09, 2022",
        "sex": "M",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "cats-lede-1.png",
        "fullname": "Victoria",
        "alias": "the White",
        "dob": "FEB 09, 2022",
        "sex": "F",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    {
        "src": "insultdog.png",
        "fullname": "Triumph",
        "alias": "the Insult Comic Dog",
        "dob": "FEB 09, 2022",
        "sex": "F",
        "height": "2' 2\"",
        "weight": "BRN",
        "eyes": "BRN",
        "hair": "BRN"
    },
    ]
    const [currentPic, setCurrentPic] = useState(Math.floor(Math.random() * (pics.length -2 )))
    const randNum = Math.floor(Math.random() * (pics.length - 2))

    return (<>
        <Carousel>
            {pics.map((e, i) => {
                return (
                    <Carousel.Item>
                        <Container fluid>
                            <Row>
                                {props.cols.map((e, i) => {
                                    const randNum = Math.floor(Math.random() * (pics.length - 2))
                                    return (<Col key={`imc2-${i}`} lg={e}>

                                    </Col>)
                                })}

                            </Row>
                        </Container>
                        {/* <Carousel.Caption>
                            <h3>{e}</h3>
                            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                        </Carousel.Caption> */}
                    </Carousel.Item>)
            })}
        </Carousel>
    </>)
}

export default ProductCrousel