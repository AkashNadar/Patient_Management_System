import React, { useState } from 'react'
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import s from './Appointment.module.css'

function Appointment() {

    const [selectedDate, setSelectedDate] = useState(null);
    const [slot, setSlot] = useState('1pm');
    const [symptoms, setSymptoms] = useState('');
    const [pastMedHist, setPastMedHist] = useState('');

    const handelChanges = (event) => {
        setSlot(event.target.value);
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
                <DatePicker selected={selectedDate} onChange={date => setSelectedDate(date)} />
                <div className="mb-3 xl:w-96">
                    <select className={s.appointment__select} onChange={handelChanges}>
                        <option value="1pm" selected>1pm</option>
                        <option value="3pm">3pm</option>
                        <option value="5pm">5pm</option>
                    </select>
                </div>
            </div>
            <div className=''>
                problem
                <div className="flex justify-center">
                    <div className="mb-3 xl:w-96">
                        <label for="symptoms" class={s.appointment__msg__label}
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
                        <label for="pastHis" class={s.appointment__msg__label}
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
                    <button className='card__button' onClick={bookAppointment} >Book Appointment</button>
                </div>
            </div>

        </section>

    )
}

export default Appointment