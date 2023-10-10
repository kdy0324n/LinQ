import { Button, Card, CardActions, CardContent, TextField ,Box} from '@mui/material'
import axios from 'axios';
import React, { useState } from 'react'
import {useCookies} from "react-cookie";
export default function SignIn() {
    const [userId,setId] = useState('');
    const [userPassword,setPassword]=useState('');
    
    const [cookies,setCookies] = useCookies();

    const data = {
        userId,
        userPassword
    }
    const signInHandler = () =>{
        if(userId.length==0 || userPassword.length==0){
            alert('아이디와 비밀번호를 입력하세요');
            return;
        }
        axios.post("http://localhost:8080/api/auth/signIn",data)
        .then((response)=>{
            const responseData = response.data;
            if(!responseData.result){
                console.log('로그인에 실패있습니다.');
                return
            }
            console.log(responseData);
            const {token,exprTime,user} = responseData.data;
            const expires = new Date();
            expires.setMilliseconds(expires.getMilliseconds + exprTime);
            setCookies('token',token, {expires});
            alert(cookies.token);
            
        })
        .catch((error) => {
            //alert('로그인에 실패했습니다.');
        })

        
    }
  return (
   <Card sx={{minWidth:275,maxWidth:"50vw"}}>
        <CardContent>
            <Box>
                <TextField
                    fullWidth
                    label="아이디"
                    variant="standard"
                    onChange={(e) => setId(e.target.value)}
                >
                </TextField>
                <TextField
                    fullWidth
                    label="비밀번호"
                    variant="standard"
                    type="password"
                    onChange={(e) => setPassword(e.target.value)}
                ></TextField>    
                
            </Box>
        </CardContent>
        <CardActions>
            <Button fullWidth onClick={() => signInHandler()} variant="contained">
                로그인
            </Button>
        </CardActions>
   </Card>
  )
}
