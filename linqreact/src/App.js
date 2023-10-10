import logo from './logo.svg';
import './App.css';
import axios from "axios";
import {useState,useEffect} from "react";
import SignUp from './view/Athentication/SugnUp';
import Athentication from './view/Athentication';
import SignIn from './view/Athentication/SignIn';

export default function App() { 

  return (
    <>
    <Athentication/>
    <SignIn/>
    </>
  );
}
