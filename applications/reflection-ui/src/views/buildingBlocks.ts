import React from "react";

import { element } from "./reactTools";
import { getpage } from "./layout";

const buildingBlocks: React.FC<{}> = () => element(
    "div",
    { className: "header" },
    "Building Blocks"
);

const page = getpage(buildingBlocks);

const constructors: React.FC<{}> = page("Constructors");
const methods: React.FC<{}> = page("Methods");
const fields: React.FC<{}> = page("Fields");
const classes: React.FC<{}> = page("Classes");
const annotations: React.FC<{}> = page("Annotations");

export {
    buildingBlocks
    , classes
    , constructors
    , methods
    , fields
    , annotations
};
