const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

import Peeps from './peeps/peeps'
import CreateUserDialog from './users/createUserDialog'


class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {peeps: [], users: [], attributes: [] };
        this.onCreate = this.onCreate.bind(this);
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/profile/users', headers: {'Accept': 'application/schema+json'}}).then(response => {
              this.setState({attributes: response.entity.properties});
              console.log(this.state);
            });
    }

    onCreate(newUser) {
        client({
            method: 'POST',
            path: '/api/users',
            entity: newUser,
            headers: {'Content-Type': 'application/json'}
            })
    }


    render() {
        return (
          <CreateUserDialog attributes={this.state.attributes} onCreate={this.onCreate}/>
        )
    }
}

ReactDOM.render(
	<App />,
	document.getElementById('app')
)