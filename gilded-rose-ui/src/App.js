import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {

    constructor() {
        super();
        this.state = {
            items : []
        }
    }

    componentDidMount() {
        this.getData();
    }

    getData() {
        fetch("http://localhost:8080/api/v1/items")
            .then((res) => res.json())
            .then(data => {
                this.setState({items: data})
            })
    }

    componentDidUpdate(prevProps, prevState) {
        if (prevState != this.state) {
            this.getData();
        }
    }

    createItem() {
        // fetch('http://localhost:8080/api/vi/items/' + )
    }

    updateQuality() {
        fetch('http://localhost:8080/api/v1/items/update-quality')
            .then(res => res.json())


    }
  render() {
    return (
        <div>
        <h1>Items!!!!</h1>
            <button class="btn btn-primary" onClick={this.updateQuality}>Iterate Day</button>
        <div>
            <h3>Create a new item</h3>

        </div>
        <div>
            <h3>Item List</h3>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Quality</th>
                        <th>Sell In</th>
                    </tr>
                </thead>
                <tbody>
                {this.state.items.map((item) => {
                    return <tr>
                        <td>{item.name}</td>
                        <td>{item.quality}</td>
                        <td>{item.sellIn}</td>
                        </tr>
                    })
                }
                </tbody>
            </table>
        </div>
        </div>
    );
  }
}

export default App;
