import axios from 'axios'
import React, { useState } from 'react'
import TextField from '@mui/material/TextField';
import { Box, Button } from '@mui/material';


import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';

export default function SignUp() {
    const time = Date.now();
    const [userId,setuserId] = useState('');
    const [userEmail,setuserEmail] = useState('');
    const [userPassword,setuserPassword] = useState('');
    const [userPasswordCheck,setuserPasswordCheck] = useState('');
    const [userName,setuserName] = useState('');
    const [userNickName,setuserNickName] = useState('');
    const [userPicture,setuserPicture] = useState('');
    const [userBirth,setuserBirth] = useState('');
    //const [userDate,setuserDate] = useState('');

    const [requestResult,setRequestResult] = useState('');
    
    const SignUpHandler = () =>{
        const data = {
            userId,
            userEmail,
            userPassword,
            userPasswordCheck,
            userName,
            userNickName,
            userPicture,
            userBirth,
            time
            //userDate
        }
        axios.post("http://localhost:8080/api/auth/signUp",data)
        .then((response)=>{
            setRequestResult('success!');
        })
        .catch((error)=>{
            setRequestResult('failed!');
        })
    }

  return (
    <Card sx={{ minWidth: 275,maxWidth:"50vw" }}>
        <CardContent>
        <Box>
        <TextField fullWidth label="아이디" variant="standard" onChange={(e)=>setuserId(e.target.value)} />
        <TextField fullWidth label="이메일" type="email" variant="standard" onChange={(e)=>setuserEmail(e.target.value)}/>
        <TextField fullWidth label="비밀번호" type='password' variant="standard" onChange={(e)=>setuserPassword(e.target.value)}/>
        <TextField fullWidth label="비밀번호확인" type='password' variant="standard" onChange={(e)=>setuserPasswordCheck(e.target.value)}/>
        <TextField fullWidth label="이름" variant="standard" onChange={(e)=>setuserName(e.target.value)}/>
        <TextField fullWidth label="닉네임" variant="standard" onChange={(e)=>setuserNickName(e.target.value)}/>
        <TextField fullWidth label="사진" variant="standard" onChange={(e)=>setuserPicture(e.target.value)}/>
        <TextField fullWidth label="생일" variant="standard" onChange={(e)=>setuserBirth(e.target.value)}/>
        {/* <TextField fullWidth label="가입날짜" variant="standard"onChange={(e)=>setuserDate(e.target.value)} /> */}
        <h3>{requestResult}</h3>
        </Box>
        </CardContent>
        <CardActions>
            <Button fullWidth onClick={() => SignUpHandler()} variant="contained">회원가입</Button>
        </CardActions>
    </Card>    
  )
}
