import React from 'react';
import { Grid, Paper, Avatar, TextField, Button, Typography, Link } from '@mui/material'
import LockIcon from '@mui/icons-material/Lock';
import { Formik, Form, Field, ErrorMessage } from 'formik'
import * as Yup from 'yup'


function ForgotPasswordForm({ handleChange }) {
    // const emailRef = useRef();
    // const passwordRef = useRef();


    const paperStyle = { padding: 20, height: '60vh', width: 280, margin: '120px auto' }
    const avatarSytyle = { backgroundColor: 'black' }
    const btnstyle = { margin: '8px 0' }

    const initialValues = {
        securityQuestion:'',
        newPassword:'',
        confirmNewPassword:''
        
    }
    const validationSchema = Yup.object().shape({
        securityQuestion: Yup.string().oneOf([Yup.ref('securityQuestion')], "Incorect").required("Required"),
        newPassword: Yup.string().required('Required').matches(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=.{8,})/,
        "Must Contain 8 Characters, One Uppercase, One Lowercase, One Number and One Special Case Character"),
        confirmNewPassword: Yup.string().oneOf([Yup.ref('newpassword')], "Password not matched").required("Required"),
        
    })
    const onSubmit = (values, props) => {
        console.log(values)
        setTimeout(() => {
            props.resetForm()
            props.setSubmitting(false)
        }, 2000)

    }


    // function submitHandler(event){
    //     event.preventDefault();
    // Read the values

    //    const email = emailRef.current.value;
    //    const password = passwordRef.current.value;
    //    const user = { email,password};
    //    // call
    //     props.loginUser(user);
    //sdgsgs

    return (
        <section>
            <Grid>
                <Paper elevation={10} style={paperStyle}>
                    <Grid align='center'>
                        <Avatar style={avatarSytyle}> <LockIcon /> </Avatar>
                        <h2>Enter details below </h2>
                    </Grid>
                    <Formik initialValues={initialValues} onSubmit={onSubmit} validationSchema={validationSchema}>
                        {(props) => (
                            <Form>
                                <p> Who is your favourite singer ?</p>
                                <Field as={TextField} label="Security Answer" name='securityQuestion' placeholder="Enter answer" 
                                fullWidth required helperText={<ErrorMessage name="securityQuestion" />}
                                />
                                <Field as={TextField} label="New Password" name="newPassword" placeholder="Enter password" type="password"
                                 fullWidth required helperText={<ErrorMessage name="newPassword" />}
                                />
                                <Field as={TextField} label=" Confirm New Password" name="confirmNewPassword" placeholder="Enter password" 
                                type="password" fullWidth required
                                    helperText={<ErrorMessage name="confirmNewPassword" />}
                                />
                                
                                <Button type='submit' color='primary' variant="contained" disabled={props.isSubmitting}
                                    style={btnstyle} fullWidth>{props.isSubmitting ? "Loading" : "Sign in"}</Button>
                            </Form>
                        )
                        }
                    </Formik>
                </Paper>
            </Grid>

        </section>
    );
}

export default ForgotPasswordForm;
