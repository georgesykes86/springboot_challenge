import React from 'react';
import Peep from './peep'

class Peeps extends React.Component {
	render() {
		var peeps = this.props.peeps.map(peep =>
			<Peep key={peep._links.self.href} peep={peep}/>
		);
		return (
      <article className='peeps-main'>
        <h1 className='peeps-title'>
          Peeps
        </h1>
  			<div className='peeps-items'>
  				{peeps}
  			</div>
      </article>
		)
	}
}

export default Peeps;