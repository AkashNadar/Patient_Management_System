import axios from 'axios';

const URL = 'http://localhost:9050/appointment';

export const checkAppointment = async (date, docId) => {
    try {
        console.log(date);
        console.log(docId);
        const res = await axios.get(`${URL}/checkAppointmentBooking?date=${date}&doctorId=${docId}`);
        return res;
    } catch (error) {
        console.log(error);
        throw new Error(error.message);
    }
}