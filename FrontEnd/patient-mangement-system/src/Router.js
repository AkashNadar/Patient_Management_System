import Login from 'Pages/Login/Login';
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
        {/* <Route element={Page404} /> */}
    </Routes>
);

export default Router;