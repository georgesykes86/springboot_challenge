import React from 'react';
import ReactDOM from 'react-dom';

class LoginForm extends React.Component {

    constructor(props){
        super(props)
        this.handleSubmit = this.handleSubmit.bind(this);
        this.validate = this.validate.bind(this);
    }

    handleSubmit(e) {
            e.preventDefault();
            if (this.validate()) {
                console.log(document.getElementById("username").value);
                console.log(document.getElementById("password").value);
                document.forms["loginForm"].submit();
            }
        }

    validate() {
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;
        if (username == "" && password == "") {
            alert("Username and password are required");
            return false;
        }
        if (username == "") {
            alert("Username is required");
            return false;
        }
        if (password == "") {
        alert("Password is required");
            return false;
        }
        return true;
    }

    render() {

        return (
                  <div>
                      <h2>Login</h2>

                        <form name="loginForm" action='/login' method="post">
                            <p key="lf1">
                                <input type="text" name="username" id="username" placeholder="Username" ref="username" className="field" />
                            </p>
                            <p key="lf2">
                                <input type="password" name="password" id="password" placeholder="Password" ref="password" className="field" />
                            </p>
                            <button onClick={this.handleSubmit}>Login</button>
                        </form>
                    </div>

        )
    }

}

export default LoginForm;