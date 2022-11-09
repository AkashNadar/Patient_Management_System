import Navbar from "Components/Navbar/Navbar";
import Login from "Pages/Login/Login";
import PatientDashboard from "Pages/PatientDashboard/PatientDashboard";
import SignUp from "./Pages/SignUp/SignUp";


function App() {
  return (
    <div>
      <Navbar />
      {/* <SignUp /> */}
      {/* <Login /> */}
      <PatientDashboard />
    </div>
  );
}

export default App;
