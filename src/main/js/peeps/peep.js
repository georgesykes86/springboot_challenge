import React from 'react';

class Peep extends React.Component{
	render() {
		return (
			<div className='peep-content'>
        {this.props.peep.content}
      </div>
		)
	}
}

export default Peep;