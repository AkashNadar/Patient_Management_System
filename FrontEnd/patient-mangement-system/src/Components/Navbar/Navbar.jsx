import React from 'react'
import s from './Navbar.module.css'
function Navbar() {
    return (
        <nav className={s.nav__container}>
            <div className={s.nav__div__container}>
                <div className={s.nav__left}>
                    <img src={require('Assets/Images/logo_img.png')} className={s.nav__img} alt="DOCCARE Logo" />
                    <span className={s.nav__img__txt}>DOCCURE</span>
                </div>

                <div className={s.nav__right} id="navbar-solid-bg">
                    <ul className={s.nav__ul}>
                        <li>
                            <a href="dfd" className={s.nav__li} aria-current="page">Home</a>
                        </li>
                        <li>
                            <a href="dfdf" className={s.nav__li}>Services</a>
                        </li>
                        <li>
                            <a href="fdf" className={s.nav__li}>Pricing</a>
                        </li>
                        <li>
                            <button type="button" className={s.nav__button}>Login / SignUp</button>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    )
}

export default Navbar