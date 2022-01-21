import React, { useState, useEffect } from "react";
import "../styles/wheel.css";

export default function Wheel(props) {
  const { facade, player, wheel } = props;

  const defaultSpin = {
    id: -1,
    fieldNumbers: 0,
    arcSize: 0,
    top: 0,
    offSet: 0,
    rotate: 0,
    resultNumber: 0,
    resultName: "",
    resultValue: 0,
    player: {
      id: -1,
      playerName: "",
      email: "",
    },
    wheel: {
      id: -1,
      wheelName: "",
      fields: [],
      company: {
        id: -1,
        companyName: "",
      },
      spins: [],
    },
    date: {
      year: 0,
      month: 0,
      day: 0,
    },
  };

  const [theSpin, setTheSpin] = useState({ ...defaultSpin });
  const [easeOut, setEaseOut] = useState(0);
  const [spinning, setSpinning] = useState(false);
  const [radius] = useState(75);
  const [bomp, setBomp] = useState(0);

  useEffect(() => {
    renderWheel();
  }, []);

  useEffect(() => {
    reset();
    renderWheel();
  }, [wheel]);

  useEffect(() => {
    if (theSpin.rotate > 0) {
      if (theSpin.fieldNumbers >= 6) {
        setBomp(theSpin.rotate - 60);
      } else {
        setBomp(theSpin.rotate - 100);
      }
    }
  }, [theSpin]);

  useEffect(() => {
    if (bomp > 0) {
      setEaseOut(1);
    } else {
      setEaseOut(0);
    }
  }, [bomp]);

  useEffect(() => {
    if (easeOut === 0) {
      setSpinning(false);
    } else {
      setTimeout(() => {
        setSpinning(true);
        console.log("Prize here: ", theSpin.resultName);
      }, 1600);
    }
  }, [easeOut]);

  const resetCanvas = () => {
    const canvas = document.getElementById("wheel");
    const ctx = canvas.getContext("2d");
    ctx.clearRect(0, 0, canvas.width, canvas.height);
  };

  const renderWheel = () => {
    resetCanvas();
    let numOptions = wheel.fields.length;
    console.log(numOptions);
    let arcSize = (2 * Math.PI) / numOptions;
    let angle = 0;
    for (let i = 0; i < numOptions; i++) {
      let text = wheel.fields[i].prizeName;
      renderSector(i + 1, text, angle, arcSize, getColor());
      angle += arcSize;
    }
  };

  const renderSector = (index, text, start, arc, color) => {
    let canvas = document.getElementById("wheel");
    let ctx = canvas.getContext("2d");
    let x = canvas.width / 2;
    let y = canvas.height / 2;
    let startAngle = start;
    let endAngle = start + arc;
    let angle = index * arc;
    let baseSize = radius * 3.33;
    let textRadius = baseSize - 150;

    ctx.beginPath();
    ctx.arc(x, y, radius, startAngle, endAngle, false);
    ctx.lineWidth = radius * 2;
    ctx.strokeStyle = color;

    ctx.font = "17px Arial";
    ctx.fillStyle = "black";
    ctx.stroke();

    ctx.save();
    ctx.translate(
      baseSize + Math.cos(angle - arc / 2) * textRadius,
      baseSize + Math.sin(angle - arc / 2) * textRadius
    );
    ctx.rotate(angle - arc / 2 + Math.PI / 2);
    ctx.fillText(text, -ctx.measureText(text).width / 2, 0);
    ctx.restore();
  };

  const getColor = () => {
    let r = Math.floor(Math.random() * 255);
    let g = Math.floor(Math.random() * 255);
    let b = Math.floor(Math.random() * 255);
    return `rgba(${r},${g},${b},0.4)`;
  };

  const spin = () => {
    facade.createSpin(player, wheel.id, (createdSpin) => {
      console.log(createdSpin);
      setTheSpin({ ...createdSpin });
    });
  };

  const reset = () => {
    setEaseOut(0);
    setBomp(0);
    setSpinning(false);
  };

  return (
    <div>
      <br />
      <div className="container">
        <div className="row">
          <div className="col-md-2"></div>
          <div className="col-md-8">
            <div className="App">
              <h1>
                Prøv lykken og vind med "{wheel.wheelName}" &#129337;&#127996;
              </h1>
              <p style={{ textAlign: "center", fontSize: "50px" }}>
                <span>&#128071;&#127995;</span>
                <span style={{ color: "white" }}></span>
              </p>
              <canvas
                id="wheel"
                width="500"
                height="500"
                style={{
                  WebkitTransform: `rotate(${bomp}deg)`,
                  WebkitTransition: `-webkit-transform ${easeOut}s ease-out`,
                  marginTop: "-100px",
                }}
              />
              <div>
                {spinning === true ? (
                  <div style={{ marginBottom: "80px" }}>
                    <div className="display">
                      <span id="readout">
                        DU VANDT:{"  "}
                        <span id="result">{theSpin.resultName}</span>
                      </span>
                    </div>
                    <button type="button" id="reset" onClick={reset}>
                      Reset
                    </button>
                  </div>
                ) : (
                  <div>
                    <button type="button" id="spin" onClick={spin}>
                      Spin
                    </button>
                  </div>
                )}
              </div>
            </div>
          </div>
          <div className="col-md-2"></div>
        </div>
      </div>
    </div>
  );
}
