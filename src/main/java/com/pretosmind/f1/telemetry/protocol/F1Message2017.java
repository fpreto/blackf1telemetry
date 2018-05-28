package com.pretosmind.f1.telemetry.protocol;

import javolution.io.Struct;

import java.nio.ByteOrder;

public class F1Message2017 extends Struct {
    public final Float32 m_time = new Float32();
    public final Float32 m_lapTime = new Float32();
    public final Float32 m_lapDistance = new Float32();
    public final Float32 m_totalDistance = new Float32();
    public final Float32 m_x = new Float32(); // World space position
    public final Float32 m_y = new Float32(); // World space position
    public final Float32 m_z = new Float32(); // World space position
    public final Float32 m_speed = new Float32(); // Speed of car in MPH
    public final Float32 m_xv = new Float32(); // Velocity in world space
    public final Float32 m_yv = new Float32(); // Velocity in world space
    public final Float32 m_zv = new Float32(); // Velocity in world space
    public final Float32 m_xr = new Float32(); // World space right direction
    public final Float32 m_yr = new Float32(); // World space right direction
    public final Float32 m_zr = new Float32(); // World space right direction
    public final Float32 m_xd = new Float32(); // World space forward direction
    public final Float32 m_yd = new Float32(); // World space forward direction
    public final Float32 m_zd = new Float32(); // World space forward direction
    public final Float32[] m_susp_pos = array(new Float32[4]); // Note: All wheel arrays have the order: RL, RR, FL, FR
    public final Float32[] m_susp_vel = array(new Float32[4]);
    public final Float32[] m_wheel_speed = array(new Float32[4]);
    public final Float32 m_throttle = new Float32();
    public final Float32 m_steer = new Float32();
    public final Float32 m_brake = new Float32();
    public final Float32 m_clutch = new Float32();
    public final Float32 m_gear = new Float32();
    public final Float32 m_gforce_lat = new Float32();
    public final Float32 m_gforce_lon = new Float32();
    public final Float32 m_lap = new Float32();
    public final Float32 m_engineRate = new Float32();
    public final Float32 m_sli_pro_native_support = new Float32();	// SLI Pro support
    public final Float32 m_car_position = new Float32(); // car race position
    public final Float32 m_kers_level = new Float32(); // kers energy left
    public final Float32 m_kers_max_level = new Float32(); // kers energy left
    public final Float32 m_drs = new Float32(); // 0 = off, 1 = on
    public final Float32 m_traction_control = new Float32(); // 0 (off) - 2 (high)
    public final Float32 m_anti_lock_brakes = new Float32(); // 0 (off) - 1 (on)
    public final Float32 m_fuel_in_tank = new Float32(); // current fuel mass
    public final Float32 m_fuel_capacity = new Float32(); // fuel capacity
    public final Float32 m_in_pits = new Float32(); // 0 = none, 1 = pitting, 2 = in pit area
    public final Float32 m_sector = new Float32(); // 0 = sector1, 1 = sector2, 2 = sector3

    @Override
    public ByteOrder byteOrder() {
        return ByteOrder.LITTLE_ENDIAN;
    }

    /*

    float m_sector1_time;	// time of sector1 (or 0)

    float m_sector2_time;	// time of sector2 (or 0)

    float m_brakes_temp[4];	// brakes temperature (centigrade)

    float m_tyres_pressure[4];	// tyres pressure PSI

    float m_team_info;	// team ID

    float m_total_laps;	// total number of laps in this race

    float m_track_size;	// track size meters

    float m_last_lap_time;	// last lap time

    float m_max_rpm;	// cars max RPM, at which point the rev limiter will kick in

    float m_idle_rpm;	// cars idle RPM

    float m_max_gears;	// maximum number of gears

    float m_sessionType;	// 0 = unknown, 1 = practice, 2 = qualifying, 3 = race

    float m_drsAllowed;	// 0 = not allowed, 1 = allowed, -1 = invalid / unknown

    float m_track_number;	// -1 for unknown, 0-21 for tracks

    float m_vehicleFIAFlags;	// -1 = invalid/unknown, 0 = none, 1 = green, 2 = blue, 3 = yellow, 4 = red

    float m_era;                    	// era, 2017 (modern) or 1980 (classic)

    float m_engine_temperature;  	// engine temperature (centigrade)

    float m_gforce_vert;	// vertical g-force component

    float m_ang_vel_x;	// angular velocity x-component

    float m_ang_vel_y;	// angular velocity y-component

    float m_ang_vel_z;	// angular velocity z-component

    byte  m_tyres_temperature[4];	// tyres temperature (centigrade)

    byte  m_tyres_wear[4];	// tyre wear percentage

    byte  m_tyre_compound;	// compound of tyre – 0 = ultra soft, 1 = super soft, 2 = soft, 3 = medium, 4 = hard, 5 = inter, 6 = wet

    byte  m_front_brake_bias;         // front brake bias (percentage)

    byte  m_fuel_mix;                 // fuel mix - 0 = lean, 1 = standard, 2 = rich, 3 = max

    byte  m_currentLapInvalid;    	// current lap invalid - 0 = valid, 1 = invalid

    byte  m_tyres_damage[4];	// tyre damage (percentage)

    byte  m_front_left_wing_damage;	// front left wing damage (percentage)

    byte  m_front_right_wing_damage;	// front right wing damage (percentage)

    byte  m_rear_wing_damage;	// rear wing damage (percentage)

    byte  m_engine_damage;	// engine damage (percentage)

    byte  m_gear_box_damage;	// gear box damage (percentage)

    byte  m_exhaust_damage;	// exhaust damage (percentage)

    byte  m_pit_limiter_status;	// pit limiter status – 0 = off, 1 = on

    byte  m_pit_speed_limit;	// pit speed limit in mph

    float m_session_time_left;  // NEW: time left in session in seconds

    byte  m_rev_lights_percent;  // NEW: rev lights indicator (percentage)

    byte  m_is_spectating;  // NEW: whether the player is spectating

    byte  m_spectator_car_index;  // NEW: index of the car being spectated



    // Car data

    byte  m_num_cars;              	// number of cars in data

    byte  m_player_car_index;        	// index of player's car in the array

    CarUDPData  m_car_data[20];   // data for all cars on track



    float m_yaw;  // NEW (v1.8)

    float m_pitch;  // NEW (v1.8)

    float m_roll;  // NEW (v1.8)

    float m_x_local_velocity;          // NEW (v1.8) Velocity in local space

    float m_y_local_velocity;          // NEW (v1.8) Velocity in local space

    float m_z_local_velocity;          // NEW (v1.8) Velocity in local space

    float m_susp_acceleration[4];   // NEW (v1.8) RL, RR, FL, FR

    float m_ang_acc_x;                 // NEW (v1.8) angular acceleration x-component

    float m_ang_acc_y;                 // NEW (v1.8) angular acceleration y-component

    float m_ang_acc_z;                 // NEW (v1.8) angular acceleration z-component


};



struct CarUDPData

{

    float m_worldPosition[3]; // world co-ordinates of vehicle

    float m_lastLapTime;

    float m_currentLapTime;

    float m_bestLapTime;

    float m_sector1Time;

    float m_sector2Time;

    float m_lapDistance;

    byte  m_driverId;

    byte  m_teamId;

    byte  m_carPosition;     // UPDATED: track positions of vehicle

    byte  m_currentLapNum;

    byte  m_tyreCompound;	// compound of tyre – 0 = ultra soft, 1 = super soft, 2 = soft, 3 = medium, 4 = hard, 5 = inter, 6 = wet

    byte  m_inPits;           // 0 = none, 1 = pitting, 2 = in pit area

    byte  m_sector;           // 0 = sector1, 1 = sector2, 2 = sector3

    byte  m_currentLapInvalid; // current lap invalid - 0 = valid, 1 = invalid

    byte  m_penalties;  // NEW: accumulated time penalties in seconds to be added

};
     */
}
