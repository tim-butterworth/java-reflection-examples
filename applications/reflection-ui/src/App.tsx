import React from 'react';
import './App.css';
import {
    viewSelector
    , views
    , NavigationOption
    , ViewState
} from "./navigation/stateMachine";
import {
    java
    , coolReflection
    , boringReflection
} from "./views/titleSequence";
import {
    topics
} from "./views/topics";
import {
    buildingBlocks
    , classes
    , constructors
    , methods
    , fields
    , annotations
} from "./views/buildingBlocks";
import {
    useful
    , dependencyInjection
    , proxies
} from "./views/useful";
import { extraTopics } from "./views/extraTopics";
import { nonsense } from "./views/nonsense";

const viewMap: { [k in views]: React.FC<{}> } = {
    java,
    coolReflection,
    boringReflection,
    topics,
    buildingBlocks,
    classes,
    constructors,
    methods,
    fields,
    useful,
    dependencyInjection,
    proxies,
    annotations,
    nonsense,
    extraTopics
};

interface NavigationState {
    activeView: views,
    navigationOptions: Array<NavigationOption>
}

class App extends React.Component<{}, NavigationState> {

    constructor(props: {}) {
        super(props);

        this.state = {
            activeView: views.JAVA,
            navigationOptions: []
        };

        this.setState.bind(this);

        viewSelector.registerViewListener(
            ({ currentView, navigationOptions }: ViewState) => {
                this.setState((state, props) => ({
                    activeView: currentView,
                    navigationOptions
                }))
            }
        );
    }

    render() {
        const showNavigationOptions = ({ transition, view }: NavigationOption) => (
            <div className="navigation" key={Math.random()}>
                <span className="navigationKey">{transition}</span><span className="navigationView">{view}</span>
            </div>
        )

        return (
            <div className="content" >
                {viewMap[this.state.activeView]({})}
                <div className="footer">
                    {this.state.navigationOptions.map(showNavigationOptions)}
                </div>
            </div>
        );
    }

    componentDidMount() {
        viewSelector.beginListening()
    }

    componentWillUnmount() {
        viewSelector.stopListening();
    }
}

export { App };
