import axios from 'axios';

const URL = 'http://localhost:1100/doctorInfo';

export const getAllDoctorInfo = async (specialization) => {
    try {
        const res = await axios.get(`${URL}/specialization/?specialization=${specialization}`);
        return res.data;
    } catch (error) {
        console.log(error);
        throw new Error(JSON.stringify(error.response));
    }

}