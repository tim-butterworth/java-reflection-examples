import React from "react";

import { element } from "./reactTools";

const header = () => element(
    "div",
    { className: "header" },
    "Topics"
);
const buildingBlocks = () => element(
    "div",
    { className: "topic" },
    "Building Blocks"
);

const maybeUseful = () => element(
    "div",
    { className: "topic" },
    "Maybe Useful"
);
const nonsense = () => element(
    "div",
    { className: "topic" },
    "Nonsense"
);
const extraTopics = () => element(
    "div",
    { className: "topic" },
    "Extra Topics"
);
const topicList = () => element(
    "div",
    { className: "topicList" },
    buildingBlocks(),
    maybeUseful(),
    nonsense(),
    extraTopics()
);

const topics: React.FC<{}> = () => element(
    "div",
    null,
    header(),
    topicList()
);

export { topics };
