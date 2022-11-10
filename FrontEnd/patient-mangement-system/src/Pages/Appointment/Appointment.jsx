import { checkAppointment } from 'Api/appointmentApi';
import React, { useEffect, useState } from 'react'
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import s from './Appointment.module.css'
import { useLocation } from 'react-router-dom';

function Appointment() {

    const location = useLocation();

    const [selectedDate, setSelectedDate] = useState(null);
    const [slot, setSlot] = useState('1pm');
    const [symptoms, setSymptoms] = useState('');
    const [pastMedHist, setPastMedHist] = useState('');
    const [appointmentAvailable, setAppointmentAvailable] = useState(false);
    const [errMsg, setErrMsg] = useState('');
    const [availTime, setAvailTime] = useState({ "1pm": true, "3pm": true, "5pm": true });
    const [docData, setDocData] = useState(location.state);

    const arr = [2, 3, 5]

    useEffect(() => {
        if (selectedDate !== null) {
            let formattedDate = `${selectedDate.getDate()}/${selectedDate.getMonth() + 1}/${selectedDate.getFullYear()}`;
            console.log(location.state);
            checkAppointment(formattedDate, docData.userId)
                .then((res) => {
                    console.log(res.data);
                    if (typeof res.data === 'boolean') {
                        setErrMsg('');
                        setAvailTime((prevState) => ({
                            ...prevState,
                            "1pm": true,
                            "3pm": true,
                            "5pm": true
                        }))
                        return;
                    }
                    console.log(res.data.length);
                    for (const time of res.data) {
                        setAvailTime((prevState) => ({
                            ...prevState,
                            [time]: false
                        }))
                    }

                })
                .catch(err => {
                    setErrMsg('No appointment available');
                    throw new Error(err);
                })
        }
    }, [selectedDate]);



    const handelChanges = (event) => {
        setSlot(event.target.value);
    }

    const handleDateChanges = (date) => {
        console.log(date);
        // console.log(typeof formattedDate);
        setSelectedDate(date);
    }

    const bookAppointment = (e) => {
        e.preventDefault();
        console.log(symptoms);
        console.log(slot);
        console.log(selectedDate);
    }

    return (
        <section>
            <div>
                Doc Info
            </div>
            <div>
                Patient Info
            </div>
            <div>
                <DatePicker selected={selectedDate} onChange={handleDateChanges} />
                <div className="mb-3 xl:w-96">
                    <select className={s.appointment__select} onChange={handelChanges}>
                        <option value="1pm" disabled={!availTime['1pm']}>1pm</option>
                        <option value="3pm" disabled={!availTime['3pm']}>3pm</option>
                        <option value="5pm" disabled={!availTime['5pm']}>5pm</option>
                    </select>
                </div>
                <div>
                    <p className={errMsg ? "error" : "hidden"}
                    >{errMsg}</p>
                </div>
            </div>
            <div className=''>
                problem
                <div className="flex justify-center">
                    <div className="mb-3 xl:w-96">
                        <label for="symptoms" className={s.appointment__msg__label}
                        >Symptoms</label>
                        <textarea
                            className={s.appointment__msg__input}
                            id="symptoms"
                            onChange={(e) => setSymptoms(e.target.value)}
                            value={symptoms}
                            required
                            rows="3"
                            placeholder="Enter your Symptoms..."
                        ></textarea>
                    </div>
                </div>
                <div className="flex justify-center">
                    <div className="mb-3 xl:w-96">
                        <label for="pastHis" className={s.appointment__msg__label}
                        >Symptoms</label>
                        <textarea
                            className={s.appointment__msg__input}
                            id="pastHis"
                            onChange={(e) => setPastMedHist(e.target.value)}
                            value={pastMedHist}
                            required
                            rows="3"
                            placeholder="Enter your Past Medical History..."
                        ></textarea>
                    </div>
                </div>
                <div className="flex justify-center">
                    <button className='card__button' onClick={bookAppointment} disabled={!appointmentAvailable}>Book Appointment</button>
                </div>
            </div>

        </section>

    )
}

export default Appointment