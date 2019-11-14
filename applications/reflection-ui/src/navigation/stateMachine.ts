enum views {
    JAVA = "java",
    BORING_REFLECTION = "boringReflection",
    COOL_REFLECTION = "coolReflection",
    TOPICS = "topics",
    BUILDING_BLOCKS = "buildingBlocks",
    CLASSES = "classes",
    CONSTRUCTORS = "constructors",
    METHODS = "methods",
    FIELDS = "fields",
    ANNOTATIONS = "annotations",
    USEFUL = "useful",
    DI = "dependencyInjection",
    PROXIES = "proxies",
    NON_SENSE = "nonsense",
    EXTRA_TOPICS = "extraTopics"
}

enum Transition {
    NONE = "none",
    ONE = "one",
    TWO = "two",
    THREE = "three",
    BACK = "back",
    RIGHT_ARROW = "->",
    LEFT_ARROW = "<-",
    TOGGLE_NAVIGATION_HELP = " "
}

enum navigationHelp {
    SHOW,
    HIDE
}

export interface NavigationOption {
    transition: Transition,
    view: views
};

const viewStateMachine: { [k in views]: Array<NavigationOption> } = {
    [views.JAVA]: [{ view: views.BORING_REFLECTION, transition: Transition.ONE }]
    , [views.BORING_REFLECTION]: [{ view: views.COOL_REFLECTION, transition: Transition.ONE }]
    , [views.COOL_REFLECTION]: [{ view: views.TOPICS, transition: Transition.ONE }]
    , [views.TOPICS]: [
        { view: views.BUILDING_BLOCKS, transition: Transition.ONE }
        , { view: views.USEFUL, transition: Transition.TWO }
        , { view: views.NON_SENSE, transition: Transition.THREE }
        , { view: views.EXTRA_TOPICS, transition: Transition.RIGHT_ARROW }
    ]
    , [views.EXTRA_TOPICS]: [
        { view: views.TOPICS, transition: Transition.BACK }
    ]
    , [views.BUILDING_BLOCKS]: [
        { view: views.CLASSES, transition: Transition.ONE }
        , { view: views.TOPICS, transition: Transition.BACK }
    ]
    , [views.CLASSES]: [
        { view: views.CONSTRUCTORS, transition: Transition.ONE }
        , { view: views.BUILDING_BLOCKS, transition: Transition.BACK }
    ]
    , [views.CONSTRUCTORS]: [
        { view: views.METHODS, transition: Transition.ONE }
        , { view: views.CLASSES, transition: Transition.BACK }
    ]
    , [views.METHODS]: [
        { view: views.FIELDS, transition: Transition.ONE }
        , { view: views.CONSTRUCTORS, transition: Transition.BACK }
    ]
    , [views.FIELDS]: [
        { view: views.ANNOTATIONS, transition: Transition.ONE }
        , { view: views.METHODS, transition: Transition.BACK }
    ]
    , [views.ANNOTATIONS]: [
        { view: views.FIELDS, transition: Transition.BACK }
        , { view: views.TOPICS, transition: Transition.ONE }
    ]
    , [views.USEFUL]: [
        { view: views.TOPICS, transition: Transition.BACK }
        , { view: views.DI, transition: Transition.ONE }
    ]
    , [views.DI]: [
        { view: views.USEFUL, transition: Transition.BACK }
        , { view: views.PROXIES, transition: Transition.ONE }
    ]
    , [views.PROXIES]: [
        { view: views.DI, transition: Transition.BACK }
        , { view: views.TOPICS, transition: Transition.ONE }
    ]
    , [views.NON_SENSE]: [
        { view: views.TOPICS, transition: Transition.BACK }
    ]
};

type viewUpdateListener = (view: ViewState) => void;
type navigationOptionsListener = (options: Array<NavigationOption>) => void;

let viewListeners: Array<viewUpdateListener> = [];
const updateNavigationHelpState = (help: navigationHelp): navigationHelp => {
    switch (help) {
        case navigationHelp.HIDE:
            return navigationHelp.SHOW;
        case navigationHelp.SHOW:
            return navigationHelp.HIDE;
    }
}
const getTransisionFunction = (
    currentView: views,
    transitions: Array<NavigationOption>
) => (transition: Transition): views => {
    let navigationOption: NavigationOption | undefined = transitions.find(
        (navOption: NavigationOption) => navOption.transition === transition
    );

    if (navigationOption) {
        return navigationOption.view;
    } else {
        return currentView;
    }
}

const getTransition = (key: string): Transition => {
    let keyTransitionMap: { [key: string]: Transition } = {
        "1": Transition.ONE,
        "2": Transition.TWO,
        "3": Transition.THREE,
        "ArrowUp": Transition.BACK,
        " ": Transition.TOGGLE_NAVIGATION_HELP,
        "ArrowRight": Transition.RIGHT_ARROW
    }

    let transition: Transition | null = keyTransitionMap[key];

    return (transition || Transition.NONE);
};

interface NavigationState {
    currentView: views;
    navigationHelpState: navigationHelp;
    navigationOptions: Array<NavigationOption>;
};
export interface ViewState {
    currentView: views;
    navigationOptions: Array<NavigationOption>;
}
let navigationState: NavigationState = {
    currentView: views.JAVA,
    navigationHelpState: navigationHelp.HIDE,
    navigationOptions: [],
};

const updateNavigationState = (previousState: NavigationState, transition: Transition): NavigationState => {
    switch (transition) {
        case Transition.TOGGLE_NAVIGATION_HELP:
            return Object.assign(
                {},
                previousState,
                { navigationHelpState: updateNavigationHelpState(previousState.navigationHelpState) }
            );
        default:
            let transitions = viewStateMachine[previousState.currentView];
            let nextView = getTransisionFunction(previousState.currentView, transitions)(transition);

            return Object.assign(
                {},
                previousState,
                {
                    navigationOptions: viewStateMachine[nextView],
                    currentView: nextView
                }
            )
    }
}

const toViewState = (navigationState: NavigationState): ViewState => {
    if (navigationState.navigationHelpState === navigationHelp.HIDE) {
        return {
            currentView: navigationState.currentView,
            navigationOptions: []
        }
    } else {
        return {
            currentView: navigationState.currentView,
            navigationOptions: navigationState.navigationOptions
        }
    }
}

const viewSelector = {
    beginListening: () => {
        window.onkeyup = (event: KeyboardEvent) => {
            const { key } = event;

            let transition = getTransition(key);
            navigationState = updateNavigationState(navigationState, transition);

            viewListeners.forEach((listener) => {
                listener(toViewState(navigationState));
            });
        }
    },
    stopListening: () => {
        window.onkeyup = null;
    },
    registerViewListener: (listener: viewUpdateListener) => {
        viewListeners.push(listener);
    }
};

export {
    viewSelector
    , views
}
