/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        primary: "#71cddc",
        secondary: "#57718d",
        cta: "#09e5ab",
        third: "#11325b"
      }
    },
  },
  plugins: [
    require('@tailwindcss/forms'),
  ],
}
