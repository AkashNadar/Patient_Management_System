import React from 'react'

function SignUp() {




    return (
        <div>
            <div className='bg-red-400 w-[600px] mx-auto'>
                <form >
                    <div className='flex flex-col'>
                        <div>
                            <div>Patient Register</div>
                            <div>Are you Doctor ?</div>
                        </div>
                        <div>
                            <input type="text" placeholder='First Name' required />

                            <input type="text" placeholder='Last Name' />
                        </div>
                        <div>
                            <label for="gender">Gender:</label>
                            <select id="gender" name="gender">
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                                <option value="others">Others</option>
                            </select>
                            <input type="text" placeholder='City' />
                        </div>
                        <div>
                            <textarea name="address" rows="3" cols="50" placeholder='Address'></textarea>
                        </div>
                        <div>
                            <input type="email" placeholder='Email' required />
                            <input type="password" placeholder='Password' required />
                            <input type="password" placeholder='Confirm Password' required />
                        </div>
                        <div>
                            <button type='submit'>Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default SignUp