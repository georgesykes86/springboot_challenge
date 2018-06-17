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
            newUser[attribute] = ReactDOM.findDOMNode(this.refs[attribute]).value.trim();
        });
        this.props.onCreate(newUser);
        Object.keys(this.props.attributes).forEach(attribute => {
            ReactDOM.findDOMNode(this.refs[attribute]).value = '';
        });
    }

    sortKeys(attributes) {
        var order = ["firstname", "lastname", "username", "email", "password", "passwordconfirm"];
        var keyOrder = [];
        Object.keys(attributes).forEach( key => {
            var index = order.indexOf(key.toString().toLowerCase());
            if (index >= 0) {
                keyOrder.push([key, attributes[key]["title"], index]);
            }
        });
        keyOrder.sort((a, b) => {
            return a[2] - b[2];
        });
        return keyOrder;
    }

    render() {

        return (
                  <div>
                      <h2>Register</h2>

                        <form>
                            {this.sortKeys(this.props.attributes).map((attribute,index) => (
                                    <p key={index}>
                                        <input type="text" placeholder={attribute[1].toString()} ref={attribute[0].toString()} className="field" />
                                    </p>
                            ))}
                            <button onClick={this.handleSubmit}>Create</button>
                        </form>
                    </div>

        )
    }

}

export default CreateUserDialog;