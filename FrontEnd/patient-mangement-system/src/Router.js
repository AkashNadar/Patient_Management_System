import Appointment from 'Pages/Appointment/Appointment';
import Login from 'Pages/Login/Login';
import PatientDashboard from 'Pages/PatientDashboard/PatientDashboard';
import SignUp from 'Pages/SignUp/SignUp';
import React from 'react';
import { Route, Routes } from 'react-router-dom';

/**
 * Routes component containing routes for the whole application
 * @returns {JSX}
 */
const Router = () => (
    <Routes>
        <Route exact path='/login' element={<Login />} />
        <Route exact path='/signUp' element={<SignUp />} />
        <Route exact path='/dashboard' element={<PatientDashboard />} />
        <Route exact path='/bookAppointment' element={<Appointment />} />
        {/* <Route element={Page404} /> */}
    </Routes>
);

export default Router;