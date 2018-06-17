const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

import Peeps from './peeps/peeps'
import CreateUserDialog from './users/createUserDialog'
import LoginForm from './users/loginForm'


class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {peeps: [], users: [], attributes: [] };
        this.onCreate = this.onCreate.bind(this);
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/profile/users', headers: {'Accept': 'application/schema+json'}}).then(response => {
              this.setState({attributes: response.entity.properties});
            });
    }

    onCreate(newUser) {
        client({
            method: 'POST',
            path: '/users',
            entity: newUser,
            headers: {'Content-Type': 'application/json'}
            })
            .then(console.log)
    }


    render() {
        let error = null;
        return (
            <div>
                <CreateUserDialog attributes={this.state.attributes} onCreate={this.onCreate} />
                <LoginForm />
                <p> {error} </p>
            </div>
        )
    }
}

ReactDOM.render(
	<App />,
	document.getElementById('app')
)