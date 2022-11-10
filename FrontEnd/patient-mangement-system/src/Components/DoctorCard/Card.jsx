import React from 'react'

function Card({ docInfo }) {
    return (
        <section>
            <div className="flex justify-center p-2">
                <div className="card__div p-10">
                    <img className="card__img" src="" alt="docImg" />
                    <div className="p-6 flex flex-col justify-start ml-10">
                        <h4 className="card__heading">
                            {docInfo.name}
                            <span className="card__badge">{docInfo.specialization}</span>
                        </h4>
                        <p className="text-gray-700 text-base mb-4">
                            {docInfo.education}
                        </p>
                        <p className="text-gray-600 text-xs">{docInfo.phoneNo}</p>
                        <div className='flex'>
                            <button type="button" className="card__button">Book Appointment</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    )
}

export default Card