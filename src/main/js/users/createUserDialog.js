import React from 'react';
import ReactDOM from 'react-dom';

class CreateUserDialog extends React.Component {

    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(e) {
        e.preventDefault();
        var newUser = {};
        Object.keys(this.props.attributes).forEach(attribute => {
            console.log(attribute)
            newUser[attribute] = ReactDOM.findDOMNode(this.refs[attribute]).value.trim();
        });
        this.props.onCreate(newUser);
        Object.keys(this.props.attributes).forEach(attribute => {
            ReactDOM.findDOMNode(this.refs[attribute]).value = '';
        });
        window.location = "#";
    }

    render() {

        return (
            <div>
                <a href="#createUser">Register</a>

                <div id="createUser" className="modalDialog">
                    <div>
                        <a href="#" title="Close" className="close">X</a>

                        <h2>Register</h2>

                        <form>
                            {Object.keys(this.props.attributes).map((attribute,index) => (
                                    <p key={index}>
                                        <input type="text" placeholder={attribute.toString()} ref={attribute.toString()} className="field" />
                                    </p>
                            ))}
                            <button onClick={this.handleSubmit}>Create</button>
                        </form>
                    </div>
                </div>
            </div>

        )
    }

}

export default CreateUserDialog;